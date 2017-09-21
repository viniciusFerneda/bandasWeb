angular.module("BandaApp").controller("EstilosController",function($scope, recursoEstilo) {

	$scope.estilos = [];
	$scope.filtro = '';
	$scope.mensagem = '';

	recursoEstilo.query(function(estilos) {
		$scope.estilos = estilos;
	}, function(erro) {
		console.log(erro);
	});

	$scope.remover = function(estilo) {
		recursoEstilo.delete({estiloId: estilo.codigo}, function() {
			var indiceDoEstilo = $scope.estilos.indexOf(estilo);
			$scope.estilos.splice(indiceDoEstilo, 1);
			$scope.mensagem = 'Estilo ' + estilo.nome + ' removido com sucesso!';
		}, function(erro) {
			console.log(erro);
			$scope.mensagem = 'Não foi possível apagar a estilo ' + estilo.nome;
		});
	};
	
});