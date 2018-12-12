'use strict';

angular.module('test')
    .service('test', function ($http) {
        return {
            get: function (id, success) {
                return $http.get("/rest/libro/" + id).then(success);
            },
            list: function (success) {
                return $http.get("/rest/libro").then(success);
            },
            save: function (book, success) {
                return $http.post("/rest/libro", book).then(success);
            },
            delete: function (id, success) {
                return $http.delete("/rest/libro/" + id).then(success);
            },
            search: function (text, success) {
                return $http.get("/rest/libro/search/" + text).then(success);
            }
  
        };
    });
