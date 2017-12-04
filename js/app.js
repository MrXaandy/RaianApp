var app = angular.module('raianApp', []);

app.controller('RaianAppController', function($scope, CoursesService) {

    $scope.course = {};
    getCourses();

    function getCourses(){
        CoursesService.getCourses().then(function(response){
            $scope.courses = response.data;
        });
    };

    $scope.salvar = function(course){
        CoursesService.salvar(course).then(function(){
            getCourses();
        });
        $scope.course = {};
    };

    $scope.editar = function(course){
        $scope.course = angular.copy(course);
    };

    $scope.excluir = function(course){
        CoursesService.excluir(course).then(getCourses);               
    };

});

app.service('CoursesService', function($http){

    var api = 'http://localhost:8080/api/webresources/courses';

    this.getCourses = function(){
        return $http.get(api);
    };

    this.salvar = function(course){
        if(!course.id){
            return $http.post(api, course);
        }
        return $http.put(api + '/' + course.id, course);
    };

    this.excluir = function(course){
        return $http.delete(api + '/' + course.id);
    };
});