/**
 * Created by higuys on 06/01/15.
 */
'use strict';

var moviedb = angular.module('moviedb');


moviedb.factory('Movie', function ($resource) {
    return $resource('rest/movies/:id', {id: '@id'}, {
        'update': {method: 'PUT'}
    });
});

moviedb.controller("MovieController",function($scope, Movie, Genre, Actor, Studio) {

    resetCurrent();

    // fetch all used data from server
    $scope.movies = Movie.query();
    $scope.genres = Genre.query();
    $scope.actors = Actor.query();
    $scope.studios = Studio.query();


    $scope.save = function() {
        var isNew = $scope.currentMovie.id == null;
        if (isNew) {
            $scope.currentMovie = Movie.save($scope.currentMovie);
            // update array to update the view (so no reload is necessary)
            $scope.movies.push($scope.currentMovie);
        } else {
            $scope.currentMovie = Movie.update($scope.currentMovie);
        }

        // reset current
        resetCurrent()
    };

    // function to cancel an edit. This will discard all changes
    $scope.cancel = function () {
        resetCurrent();
    };

    $scope.edit = function (movie) {
        $scope.currentMovie = movie;
        //$scope.currentMovie.author = filterById($scope.authors, book.author.id);
    }


    $scope.remove = function (index, id) {
        $scope.movies.splice(index, 1);
        Movie.remove({id: id});

        // reset current
        resetCurrent();
    };

    $scope.getGenreNameById = function(id){
        var genre = findById($scope.genres, id);
        if (genre) {
            return genre.label;
        }
        return "unknown genre";
    };

    $scope.getStudioNameById = function(id){
        var studio = findById($scope.studios, id);
        if (studio) {
            return studio.label;
        }
        return "unknown studio";
    };

    $scope.getActorNameById = function(id){
        var actor = findById($scope.actors, id);
        if (actor) {
            return actor.birthname + " " + actor.name;
        }
        return "unknown actor";
    };

    // configure multi selects
    $scope.actor_dropdown_settings = {displayProp: 'name'};
    $scope.studio_dropdown_settings = {displayProp: 'label'};

    function resetCurrent() {
        $scope.currentMovie = new Movie();
        $scope.currentMovie.genres = [];
        $scope.currentMovie.actors = [];
        $scope.currentMovie.studios = [];
    };
});

// configure routing
moviedb.config(function config( $stateProvider ) {
    $stateProvider.state( 'movies', {
        url: '/movies',
        templateUrl: 'pages/movies.tpl.html'
    });
})


function findById(array, id) {
    var result = array.filter(function (object) {
        return object.id == id;
    });

    if(result && result.length == 1) {
        return result[0];
    }
    return null;
}

function filterById(array, id) {
    return array.filter(function (object) {
        return object.id == id;
    })[0];
}