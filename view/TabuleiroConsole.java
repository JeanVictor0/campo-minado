package view;

import java.util.Scanner;

import modelo.*;

class TabuleiroConsole {
  private Tabuleiro tabuleiro;
  private Scanner entrada = new Scanner(System.in);
  
  public TabuleiroConsole(Tabuleiro tabuleiro){
    this.tabuleiro = tabuleiro;

    this.executarJogo();
  }

  private void executarJogo(){
    try {
      boolean continuar = true;  

      while (continuar){
        ciclodoJogo();

        
        System.out.println("Deseja outra partida? (S/n)");
        String resposta = entrada.nextLine();
        if("n".equalsIgnoreCase(resposta)){
          
        } else if ("s".equalsIgnoreCase(resposta)){
          tabuleiro.reiniciar();
        } else {
          System.out.println("Desculpa");
        }
        
      }
    } catch (SairException e) {
      System.out.println("Tchauuu!");
    } finally {
      entrada.close();
    }
  }

  private void cicloDoJogo(){
    try {
      while (!tabuleiro.objetivoAlcancado()){
        System.out.println(tabuleiro);
        String digitado = capturarValorDigitado("Digite (x,y): ");
        Arrays.stream(digitado.split(","))
          .map(e -> Integer.parseInt(e.trim())); 
      }
      String novoDitado = capturarValorDigitado("1 - abrir 2 - (des)marcar");

      if ("1".equalsIgnoreCase(novoDigitado)){
        tabuleiro.abrir(xy.next(),xy.next());
      } else if ("2".equalsIgnoreCase(novoDIgitado)){
        tabuleiro.alternarMarcacao(xy.next(),xy.next());
      }
      
      System.out.println("Voce ganhou!");
    } catch (explosaoException e){
      System.out.println("Voce perdeu");
    }
  }

  private void capturarValorDigitado(String texto){
    System.out.println(texto);
    String digitado = entrada.nextLine();
    
    if ("sair".equalsIgnoreCase(digitado)){
      System.out.println("Tchau!!!");
      throw new SairException();
    } 
  }
}