'use strict';

angular.module('test')
    .service('test', function ($http) {
        return {
            get: function (id, success) {
                return $http.get("/rest/test/" + id).then(success);
            },
            list: function (success) {
                return $http.get("/rest/test").then(success);
            },
            save: function (book, success) {
                return $http.post("/rest/test", book).then(success);
            },
            delete: function (id, success) {
                return $http.delete("/rest/test/" + id).then(success);
            },
            search: function (text, success) {
                return $http.get("/rest/test/search/" + text).then(success);
            }
  
        };
    });
