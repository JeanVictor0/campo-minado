package teste;

import modelo.Campo;
import org.junit.jupiter.api.Test;

class CampoTeste {
  private Campo vizinho = new Campo(3,3);
  boolean resultado = Campo.adicionarVizinho(vizinho);
  
  @BeforeEach
  void iniciarCampo(){
    campo = new Campo(3,2);
  }
  
  @Test
  void testeVizinhoRealDistanciaEsquerda(){
    Campo vizinho = new Campo(3,2);
    assertTrue(resultado);
    
  }

  @Test
  void testeVizinhoRealDistanciaDireita(){
    Campo vizinho = new Campo(3,4);
    assertTrue(resultado);
    
  }

  @Test
  void testeVizinhoRealDistanciaEncima(){
    Campo vizinho = new Campo(2,3);
    assertTrue(resultado);
    
  }

  @Test
  void testeVizinhoRealDistanciaBaixo(){
    Campo vizinho = new Campo(4,3);
    assertTrue(resultado);
    
  }

  @Test
  void testeVizinhoRealDistancia2(){
    Campo vizinho = new Campo(2,2);
    assertTrue(resultado);
    
  }

  @Test
  void testeNaoVizinhoRealDistancia(){
    Campo vizinho = new Campo(2,2);
    assertTrue(resultado);
    
  }

  @Test
  void testeAlternarMarcacao(){
    
  }
  
  
}