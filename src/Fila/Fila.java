import java.util.function.Function;

public class Fila<E> {
    private Celula primeiro,ultimo;
     public Fila(){
     primeiro= new Celula();
     ultimo=primeiro;
     }
   public void inserir(E x){
    Celula novo;
    novo = new Celula(x);
   ultimo.setProximo(novo);
   ultimo=novo;
    /*Algoritmo Inserir(Fila, elemento)
    novo ← alocar Nó
    novo.valor ← elemento
    novo.prox ← nulo

    Se (Fila.inicio == nulo) então
        // fila está vazia
        Fila.inicio ← novo
        Fila.fim ← novo
    Senão
        // liga o último nó ao novo
        Fila.fim.prox ← novo
        Fila.fim ← novo
    FimSe
FimAlgoritmo

 */
   }

   public E remover(){
    if(vazia()){
        System.err.println("a fila esta vazia nao foi possivel remover ");
        return null;
    }
    else{
        Celula aux=primeiro.getProximo();
        E valor = (E) aux.getItem();
        primeiro.setProximo(aux.getProximo());
        if(primeiro.getProximo()==null){
            ultimo=primeiro;
        }
        return valor;

    }

   
   }
  public boolean vazia(){
     /*Algoritmo Remover(Fila)
    Se (Fila.vazia()) então
        Escrever "Erro: fila vazia"
    Senão
        Celula aux ← Fila.primeiro.prox
        valor ← aux.item
        Fila.primeiro.prox ← aux.prox
        Se (Fila.primeiro.prox == nulo) então
            Fila.ultimo ← Fila.primeiro
        FimSe
        Retornar valor
    FimSe
FimAlgoritmo */
    if (primeiro.getItem()==ultimo.getItem()){
        return true;
    }
    else{return false;}
  }


  public void mostrar(){
    /*Algoritmo Mostrar(Fila)
    Se (Fila.vazia()) então
        Escrever "A fila está vazia"
    Senão
        Celula aux ← Fila.primeiro.prox
        Enquanto (aux ≠ nulo) faça
            Escrever aux.item
            aux ← aux.prox
        FimEnquanto
    FimSe
FimAlgoritmo */
   if(vazia()){System.err.println("a fila esta vazia");}
   else{
    Celula aux=new Celula(primeiro.getProximo());
    while(aux!=null){
        System.out.println(aux.getItem());
       aux = aux.getProximo();

    }

   }


  }
public double calcularValorMedio(Function<E, Double> extrator, int quantidade){
   if(vazia()){System.err.println("impossivel!!!!!!!!!!!!! \n fila vazia");return -0.0;}
   else {   double soma = 0.0;
    int contador = 0;
     Celula atual=primeiro.getProximo();
     while (atual != null && contador < quantidade){
        E item=(E) atual.getItem();
        soma+=extrator.apply(item);
        contador++;
        atual=atual.getProximo();
     }
     return soma/contador;


   }
}



}
