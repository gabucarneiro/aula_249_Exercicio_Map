package program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Programa2_0 {
	/* Na contagem de votos de uma eleição, são gerados vários registros
	 * de votação contendo o nome do candidato e a quantidade de votos (formato .csv)
	 * que ele obteve em uma urna de votação. Você deve fazer um programa para ler os
	 * registros de votação a partir de um arquivo, e daí gerar um relatório consolidado
	 * com os totais de cada candidato.
	 * 
	 * Nome do arquivo: "input.txt"
	 * Conteúdo:
	 * Alex Blue,15
	 * Maria Green,22
	 * Bob Brown,21
	 * Alex Blue,30
	 * Bob Brown,15
	 * Maria Green,27
	 * Maria Green,22
	 * Bob Brown,25
	 * Alex Blue,31
	 * 
	 * Resultado:
	 * Alex Blue: 76
	 * Bob Brown: 61
	 * Maria Green: 71
	 * Total de votos: 208
	 * */
	
	public static String printit(String candidatoo) {
		//System.out.println(candidatoo + ": ");
		return candidatoo + ": ";
	}

	public static void main(String[] args) {
		String inputFile = "F:\\eclipse\\workspace\\aula_249_Exercicio_Map\\input.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(inputFile))){
			String line;
			Map<String, Integer> contagem = new TreeMap<String, Integer>();
			while((line = br.readLine()) != null) {
				String[] candidato = new String[line.split(",").length];
				candidato = line.split(",");
				if(contagem.containsKey(candidato[0])) {
					int votos = contagem.get(candidato[0]);
					votos += Integer.parseInt(candidato[1]);
					contagem.put(candidato[0], votos);
				}
				else {
					contagem.put(candidato[0], Integer.parseInt(candidato[1]));
				}
			}
			System.out.println("Resultado:");
			for(String cand : contagem.keySet()) {
				System.out.println(cand + ": " + contagem.get(cand));
			}
			contagem.keySet().forEach(System.out::println);
			contagem.values().forEach(System.out::println);
			contagem.keySet().forEach(Programa2_0::printit);
			//Programa2_0::printit
			System.out.println("Total de votos: " + contagem.values().stream().reduce(0, Integer::sum));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
