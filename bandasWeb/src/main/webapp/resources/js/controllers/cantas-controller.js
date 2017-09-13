angular.module("BandaApp").controller("CantasController",function($scope, recursoCanta) {

	$scope.cantas = [];
	$scope.filtro = '';
	$scope.mensagem = '';

	recursoCanta.query(function(cantas) {
		$scope.cantas = cantas;
	}, function(erro) {
		console.log(erro);
	});

	$scope.remover = function(canta) {
		recursoCanta.delete({cantaId: canta._id}, function() {
			var indiceDaCanta = $scope.cantas.indexOf(canta);
			$scope.cantas.splice(indiceDaCanta, 1);
			$scope.mensagem = 'Canta ' + canta.banda + ' removida com sucesso!';
		}, function(erro) {
			console.log(erro);
			$scope.mensagem = 'Não foi possível apagar a canta ' + canta.banda;
		});
	};
	
});