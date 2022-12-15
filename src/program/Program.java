package program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Program {
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
	 * */

	public static void main(String[] args) {
		String inputFile = "F:\\eclipse\\workspace\\aula_249_Exercicio_Map\\input.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
			String linha;
			Map<String, String> votos = new TreeMap<>();
			while ((linha = br.readLine()) != null) {
				String[] separador = linha.split(",");
				if (votos.containsKey(separador[0])) {
					Integer qnt = Integer.parseInt(votos.get(separador[0]));
					qnt += Integer.parseInt(separador[1]);
					votos.put(separador[0], String.valueOf(qnt));
				} else {
					votos.put(separador[0], separador[1]);
				}
			}
			for(String ladrao : votos.keySet()) {
				System.out.println(ladrao + ": " + votos.get(ladrao));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		String inputFilee = "F:\\eclipse\\workspace\\aula_249_Exercicio_Map\\input.txt";
		
		Map<String, Integer> votosPorUrna = new TreeMap<>();
		try(BufferedReader br = new BufferedReader(new FileReader(inputFilee))) {
			String line;
			while((line = br.readLine()) != null) {
				String[] splited = line.split(",");
				
				if(votosPorUrna.containsKey(splited[0])) {
					votosPorUrna.put(splited[0], ((votosPorUrna.get(splited[0])) + Integer.parseInt(splited[1])));
				}
				else {
					votosPorUrna.put(splited[0], Integer.parseInt(splited[1]));
				}				
			}
			int totalVotos = 0;
			for(String candidatos : votosPorUrna.keySet()) {
				System.out.println(candidatos + ": " + votosPorUrna.get(candidatos));
				totalVotos += votosPorUrna.get(candidatos);
			}
			
			/*APENAS PARA TESTE*/
			List<Integer> listaCandidatos = new ArrayList<>();
			for(Integer s : votosPorUrna.values()) {
				listaCandidatos.add(s);
			}			
			Integer sume = listaCandidatos.stream().reduce(0, Integer::sum);
			System.out.println("sume: " + sume);
			/*APENAS PARA TESTE*/
			
			/*APENAS PARA TESTE*/
			Collection<Integer> listaCandidatoss = votosPorUrna.values();						
			Integer sums = listaCandidatoss.stream().reduce(0, Integer::sum);
			System.out.println("sums: " + sums);
			/*APENAS PARA TESTE*/
			
			/*APENAS PARA TESTE*/					
			Integer sumss = votosPorUrna.values().stream().reduce(0, Integer::sum);
			System.out.println("sumss: " + sumss);
			/*APENAS PARA TESTE*/
			
			System.out.println("Total de votos: " + totalVotos);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
