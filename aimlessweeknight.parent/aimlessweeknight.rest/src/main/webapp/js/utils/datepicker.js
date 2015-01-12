/**
 * Created by Christian on 11.01.2015.
 */
var datepicker = angular.module('ui.bootstrap.datepicker').controller('DatePickerController', function ($scope) {
    $scope.today = function() {
        $scope.date = new Date();
    };
    //$scope.today();

    $scope.clear = function() {
        $scope.date = null;
    };
    /*
    $scope.toogleMin = function() {
        $scope.minDate = $scope.minDate ? null : new Date();
    };
    $scope.toogleMin();
    */

    $scope.open = function($event) {
        $event.preventDefault();
        $event.stopPropagation();

        $scope.opened = true;
    };

    $scope.dateOptions = {
        formatYear: 'yy',
        startingDay: 1
    };

    $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
    $scope.format = $scope.formats[2];
});