'use strict';

angular.module('test')
    .controller('DetailCtrl', function ($scope, $routeParams, test) {

        $scope.load = function() {
            test.get($routeParams.id,function (detail) {
                $scope.form = detail.data;
            });
        }

        $scope.load();
    });
