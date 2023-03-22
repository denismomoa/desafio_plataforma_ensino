package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Lesson> list = new ArrayList();
		
		System.out.print("Quantas aulas tem o curso? ");
		int count = sc.nextInt();
		
		System.out.println();
		
		for(int i =1; i <= count; i++) {
			System.out.println("Dados da " + i + "a aula:");
			
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			char c = sc.next().charAt(0);
			
			System.out.print("Título: ");
			sc.nextLine();
			String title = sc.nextLine();
			
			if(c == 'c') {
				System.out.print("URL do vídeo: ");
				String url = sc.nextLine();
				
				System.out.print("Duração em segundos: ");
				int seconds = sc.nextInt();
				
				list.add(new Video(title, url, seconds));
				System.out.println();
			}
			else if(c == 't') {
				System.out.print("Descrição: ");
				String description = sc.nextLine();
				
				System.out.print("Quantidade de questões: ");
				int questions = sc.nextInt();
				
				list.add(new Task(title, description, questions));
				System.out.println();
			}
		}
		
		int totalSeconds = 0;
		for(Lesson l : list) {
			totalSeconds += l.duration();
		}
		
		System.out.println("DURAÇÃO TOTAL DO CURSO = " + totalSeconds + " segundos");
		
		sc.close();

	}

}
