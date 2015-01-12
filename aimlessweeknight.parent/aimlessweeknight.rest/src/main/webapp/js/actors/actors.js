/**
 * Created by higuys on 06/01/15.
 */
'use strict';

var moviedb = angular.module('moviedb');

moviedb.factory('Actor', function ($resource) {
    return $resource('rest/actors/:id', {id: '@id'}, {
        'update': {method: 'PUT'}
    });
});

moviedb.controller("ActorController",function($scope, Actor) {


    $scope.currentActor = new Actor();

    // fetch all genres from server
    $scope.actors = Actor.query();

    $scope.save = function() {
        var isNew = $scope.currentActor.id == null;
        if (isNew) {
            $scope.currentActor = Actor.save($scope.currentActor);
            // update array to update the view (so no reload is necessary)
            $scope.actors.push($scope.currentActor);
        } else {
            $scope.currentActor = Actor.update($scope.currentActor);
        }

        // reset current
        $scope.currentActor = new Actor();
    };

    // function to cancel an edit. This will discard all changes
    $scope.cancel = function () {
        $scope.currentActor = new Actor();
    };

    $scope.edit = function (actor) {
        $scope.currentActor = actor;
    }


    $scope.remove = function (index, id) {
        $scope.actors.splice(index, 1);
        Actor.remove({id: id});

        // reset current
        $scope.currentActor = new Actor();
    };
});

// configure routing
moviedb.config(function config( $stateProvider ) {
    $stateProvider.state( 'actors', {
        url: '/actors',
        templateUrl: 'pages/actors.tpl.html'
    });
});