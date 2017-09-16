angular.module("BandaApp").controller("PaisesController",function($scope, recursoPais) {

	$scope.paises = [];
	$scope.filtro = '';
	$scope.mensagem = '';
	
	recursoPais.query(function(paises) {
		$scope.paises = paises;
	}, function(erro) {
		console.log(erro);
	});

	$scope.remover = function(pais) {
		recursoPais.delete({paisId: pais._id}, function() {
			var indiceDoPais = $scope.paises.indexOf(pais);
			$scope.paises.splice(indiceDoPais, 1);
			$scope.mensagem = 'País ' + pais.nome + ' removido com sucesso!';
		}, function(erro) {
			console.log(erro);
			$scope.mensagem = 'Não foi possível apagar o país ' + pais.nome;
		});
	};
	
});