/**
 * Created by higuys on 06/01/15.
 */
'use strict';

var moviedb = angular.module('moviedb');

moviedb.factory('Studio', function ($resource) {
    return $resource('rest/studios/:id', {id: '@id'}, {
        'update': {method: 'PUT'}
    });
});

moviedb.controller("StudioController",function($scope, Studio) {

    $scope.currentStudio = new Studio();

    // fetch all studios from server
    $scope.studios = Studio.query();

    $scope.save = function() {
        var isNew = $scope.currentStudio.id == null;
        if (isNew) {
            $scope.currentStudio = Studio.save($scope.currentStudio);
            // update array to update the view (so no reload is necessary)
            $scope.studios.push($scope.currentStudio);
        } else {
            $scope.currentStudio = Studio.update($scope.currentStudio);
        }

        // reset current
        $scope.currentStudio = new Studio();
    };

    // function to cancel an edit. This will discard all changes
    $scope.cancel = function () {
        $scope.currentStudio = new Studio();
    };

    $scope.edit = function (studio) {
        $scope.currentStudio = studio;
    }


    $scope.remove = function (index, id) {
        $scope.studios.splice(index, 1);
        Studio.remove({id: id});

        // reset current
        $scope.currentStudio = new Studio();
    };
});

// configure routing
moviedb.config(function config( $stateProvider ) {
    $stateProvider.state( 'studios', {
        url: '/studios',
        templateUrl: 'pages/studios.tpl.html'
    });
});