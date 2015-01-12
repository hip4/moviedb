/**
 * Created by higuys on 06/01/15.
 */
'use strict';
var moviedb = angular.module('moviedb', ['ui.bootstrap','ui.router','ngResource','angularjs-dropdown-multiselect']);
moviedb.config(function config($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/movies');
});