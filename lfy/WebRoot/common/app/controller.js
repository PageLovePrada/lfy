
angular.module("app", [])
	.directive('testdo',function(){
		return function(scope,element,attrs){
			element.bind('mouseover',function(){
				scope.$apply(attrs.testdo)
			})
		}
	})
	.controller("thrController", function($scope, $http,car,testt) {
		$scope.fun1=function(){console.log("fun1")}
	})
	.factory('car',function(){
		this.a = 1
		return{
			car:this.a
		}
	})
	.service('testt',function(){
		return{
			car:[]
		}
	})
	//首页
	.controller("mainController", function($scope, $http, car) {
		$scope.data = car;
		$scope.click=function(){
			$scope.data.car.push(1)
			console.log($scope.data.car);
		}
	})
	.controller("twoController", function($scope, $http, car) {
		$scope.data = car;
		$scope.click=function(){
			$scope.data.car.push(2)
			console.log($scope.data.car);
		}
	});