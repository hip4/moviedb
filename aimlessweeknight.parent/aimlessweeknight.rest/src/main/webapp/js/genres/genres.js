/**
 * Created by higuys on 06/01/15.
 */
'use strict';

var moviedb = angular.module('moviedb');

moviedb.factory('Genre', function ($resource) {
    return $resource('rest/genres/:id', {id: '@id'}, {
        'update': {method: 'PUT'}
    });
});

moviedb.controller("GenreController",function($scope, Genre) {


    $scope.currentGenre = new Genre();

    // fetch all genres from server
    $scope.genres = Genre.query();

    $scope.save = function() {
        var isNew = $scope.currentGenre.id == null;
        if (isNew) {
            $scope.currentGenre = Genre.save($scope.currentGenre);
            // update array to update the view (so no reload is necessary)
            $scope.genres.push($scope.currentGenre);
        } else {
            $scope.currentGenre = Genre.update($scope.currentGenre);
        }

        // reset current
        $scope.currentGenre = new Genre();
    };

    // function to cancel an edit. This will discard all changes
    $scope.cancel = function () {
        $scope.currentGenre = new Genre();
    };

    $scope.edit = function (genre) {
        $scope.currentGenre = genre;
    }


    $scope.remove = function (index, id) {
        $scope.genres.splice(index, 1);
        Genre.remove({id: id});

        // reset current
        $scope.currentGenre = new Genre();
    };
});

// configure routing
moviedb.config(function config( $stateProvider ) {
    $stateProvider.state( 'genres', {
        url: '/genres',
        templateUrl: 'pages/genres.tpl.html'
    });
});