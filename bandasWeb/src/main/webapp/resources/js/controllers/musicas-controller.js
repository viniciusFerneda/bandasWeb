angular.module("BandaApp").controller("MusicasController",function($scope, recursoMusica) {

	$scope.musicas = [];
	$scope.filtro = '';
	$scope.mensagem = '';

	recursoMusica.query(function(musicas) {
		$scope.musicas = musicas;
	}, function(erro) {
		console.log(erro);
	});

	$scope.remover = function(musica) {
		recursoMusica.delete({musicaId: musica._id}, function() {
			var indiceDaMusica = $scope.musicas.indexOf(musica);
			$scope.musicas.splice(indiceDaMusica, 1);
			$scope.mensagem = 'Música ' + musica.nome + ' removida com sucesso!';
		}, function(erro) {
			console.log(erro);
			$scope.mensagem = 'Não foi possível apagar a música ' + musica.nome;
		});
	};
	
});