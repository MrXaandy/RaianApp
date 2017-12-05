var app = angular.module('raianApp', ['ngRoute']);

app.config(function($routeProvider){
    $routeProvider.when('/cadastre-course', {
        controller: 'CourseCadastreController',
        templateUrl: 'templates/cadastre-course.html'
    }).when('/cadastre-course:id', {
        controller: 'CourseCadastreController',
        templateUrl: 'templates/cadastre-course.html'
    }).when('/table-course', {
        controller: 'CourseTableController',
        templateUrl: 'templates/table.html'
    }).when('/no-course', {
        templateUrl: 'templates/no-course.html'
    }).when('/home', {
        controller: 'CourseTableController',
        templateUrl: 'templates/home.html'
    }).when('/cadastre-discipline', {
        controller: 'DisciplineCadastreController',
        templateUrl: 'templates/cadastre-discipline.html'
    }).when('/table-discipline', {
        controller: 'DisciplineTableController',
        templateUrl: 'templates/table-discipline.html'
    }).otherwise('/home');
});
    
app.controller('CourseCadastreController', function($routeParams, $scope, $location, Service){
    
    var id = $routeParams.id;
    
    if(id){
        Service.getCourse(id).then(function(response){
            $scope.course = response.data;
        });
    }else{
        $scope.course = {};
    }

    $scope.saveCourse = function(course){
       Service.saveCourse(course).then(function(){
       $scope.course = {};
       $location.path('/table');
       });
   };
});

app.controller('CourseTableController', function($scope, $location, Service){
    getCourses();
    getDisciplines();
    function getCourses(){
        Service.getCourses().then(function(response){
            $scope.courses = response.data;
        });
    };
    
    function getDisciplines(){
        Service.getDisciplines().then(function(response){
            $scope.disciplines = response.data;
        });
    };
    
    $scope.deleteCourse = function(course){
        Service.deleteCourse(course).then(getCourses);               
    };
    
    $scope.deleteDiscipline = function(discipline){
        Service.deleteDiscipline(discipline).then(getDisciplines);               
    };
});

app.controller('DisciplineCadastreController', function($routeParams, $scope, $location, Service){
    
    var id = $routeParams.id;
    
    if(id){
        Service.getDiscipline(id).then(function(response){
            $scope.discipline = response.data;
        });
    }else{
        $scope.discipline = {};
    }

    $scope.saveDiscipline = function(discipline){
       Service.saveDiscipline(discipline).then(function(){
       $scope.discipline = {};
       $location.path('/table-discipline');
       });
   };
});

app.controller('DisciplineTableController', function($scope, $location, Service){
    getDisciplines();
     
    function getDisciplines(){
        Service.getDisciplines().then(function(response){
            $scope.disciplines = response.data;
        });
    };
    
    $scope.deleteDiscipline = function(discipline){
        Service.deleteDiscipline(discipline).then(getDisciplines);               
    };
});

app.service('Service', function($http){

    var api = 'http://localhost:8080/api/webresources/';
    
    this.getCourses = function(){
        return $http.get(api + "courses");
    };
    this.getDisciplines = function(){
        return $http.get(api + "disciplines");
    };
    
    this.getCourse = function(id){
        return $http.get(api + 'courses/' + id);
    };
    
    this.getDiscipline = function(id){
        return $http.get(api + 'disciplines/' + id);
    };

    this.saveCourse = function(course){
        if(!course.id){
            return $http.post(api + 'courses/', course);
        }
        return $http.put(api + 'courses/' + course.id, course);
    };
    
    this.saveDiscipline = function(discipline){
        if(!discipline.id){
            return $http.post(api + 'disciplines/', discipline);
        }
        return $http.put(api + 'disciplines/' + discipline.id, discipline);
    };

    this.deleteCourse = function(course){
        return $http.delete(api + 'courses/' + course.id);
    };
    
    this.deleteDiscipline = function(discipline){
        return $http.delete(api + 'disciplines/' + discipline.id);
    };
});