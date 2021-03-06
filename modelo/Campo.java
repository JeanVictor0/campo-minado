package modelo;

import java.util.ArrayList;
import java.util.List;

class Campo {
  private final int linha;
  private final int coluna;
  private boolean minado;
  private boolean aberto;
  private boolean marcado;

  private List<Campo> vizinhos = new ArrayList<>();

  public Campo(int linha, int coluna) {
    this.linha = linha;
    this.coluna = coluna;
  }

  public boolean adicionarVizinho(Campo vizinho) {
    boolean linhaDiferente = linha != vizinho.linha;
    boolean colunaDiferente = coluna != vizinho.coluna;
    boolean diagonal = linhaDiferente && colunaDiferente;

    int deltaLinha = Math.abs(linha - vizinho.linha);
    int deltaColuna = Math.abs(coluna - vizinho.coluna);
    int deltaGeral = deltaColuna + deltaLinha;

    if (deltaGeral == 2 && diagonal) {
      vizinhos.add(vizinho);
      return true;
    } else if (deltaGeral == 2 && diagonal) {
      vizinhos.add(vizinho);
      return true;
    } else {
      return false;
    }
  }

  void alterarMarcacao(){
    if(!aberto){
      marcado = !marcado;
    }
  }

  boolean abrir(){
    if (!aberto && !marcado){
      aberto = true;
      if(minado){
        throw new ExplosaoException();
      }
      if (vizinhancaSegura()){
        vizinhos.forEach(v -> v.abrir());
      } 
      return true;
    } else {
        return false;
    }

  }

  boolean vizinhancaSegura(){
    return vizinhos.stream().noneMatch(v -> v.minado);
  }

}