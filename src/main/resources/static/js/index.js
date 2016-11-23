angular.module('demo', []).controller('Hello', function($scope, $http) {
	$http.get('/api/questions').then(function(response) {
		$scope.questions = response.data._embedded.questions;
		$scope.questionList = [];
		angular.forEach($scope.questions, function(value, key) {
			var str = value._links.self.href;
			var n = str.lastIndexOf('/');
			var result = str.substring(n + 1);
			var question = {
				id : result,
				displayText : value.displayText,
				answer : {
					value : 1,
					comment : ""
				}
			};
			$scope.questionList.push(question);
		});
//		console.log($scope.questionList);
	});

	
	$scope.update = function(questionList, other) {
		var res = $http.post('/api/reviews', {"comments" : other});
		res.success(function(data, status, headers, config) {
			console.log(data);
		
		var str = data._links.self.href;
		var n = str.lastIndexOf('/');
		var reviewId = str.substring(n + 1);
		
		for(i=0; i<questionList.length; i++) {
			var question = questionList[i];
			var res = $http.post('/api/answers', 
					{"reviewId" : reviewId, "questionId" : question.id, "rating" : question.answer.value, "comment" : question.answer.comment});
			res.success(function(data, status, headers, config) {
//				console.log(data);
			});
		}
		window.location.assign("/thanks.html");
		
//		console.log(other);
		});
	};
});