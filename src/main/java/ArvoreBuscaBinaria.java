class ArvoreBuscaBinaria {
  
  private No raiz;
  No atual;
  No sucessor;


  public void inserirProduto(Produto produto){
    raiz = inserir(raiz, produto);
  }

  public No inserir(No raiz, Produto produto){
    if(raiz==null){
      return new No(produto);
    }
    if(produto.getCodigo()<raiz.produto.getCodigo()){
      raiz.esquerdo = inserir(raiz.esquerdo, produto);
      raiz.esquerdo.pai = raiz;
    }else if(produto.getCodigo()>raiz.produto.getCodigo()){
      raiz.direito = inserir(raiz.direito, produto);
      raiz.direito.pai = raiz;
    }else{
      System.out.println("Produto já cadastrado");
    }
    return raiz;
  }

  public void removerProduto(int codigo){
    raiz = remover(raiz, codigo);
  }

  public No remover(No raiz, int codigo){
    if(raiz==null){
      return raiz;
    }
    if(codigo<raiz.produto.getCodigo()){
      raiz.esquerdo = remover(raiz.esquerdo, codigo);
    }else if(codigo>raiz.produto.getCodigo()){
      raiz.direito = remover(raiz.direito, codigo);
    }else{ // caso nenhum ou 1 filho
      if(raiz.esquerdo==null){ // caso 1 filho direito
        No aux = raiz.direito;
        if(aux!=null){
          aux.pai = raiz.pai;
        }
        return aux;
      }else if(raiz.direito==null){ // caso 1 filho esquerdo
        No aux = raiz.esquerdo;
        if(aux!=null){
          aux.pai = raiz.pai;
        }
        return aux;
      }
      // caso 2 filhos
      No sucessor = raiz.direito;
      while(sucessor.esquerdo!=null){
          sucessor = sucessor.esquerdo;
      }
      raiz.produto = sucessor.produto;
      raiz.direito = remover(raiz.direito, sucessor.produto.getCodigo());
    }
    return raiz;
  }


  public void buscarProduto(int codigo){
    buscar(raiz, codigo);
  }

  public void buscar(No raiz, int codigo){
    if(raiz == null){
      System.out.println("Produto não encontrado");
      return;
    }
    if(raiz.produto.codigo>codigo){
      buscar(raiz.esquerdo, codigo);
    }else if(raiz.produto.codigo<codigo){
      buscar(raiz.direito, codigo);
    }else{
      System.out.println("");
      System.out.println("Produto encontrado: ");
      System.out.println("Nome: " + raiz.produto.nome);
      System.out.println("Quantidade: " + raiz.produto.quantidade);
    }
  }

  public void imprimirArvore(){
    imprimir(raiz);
  }

  public void imprimir(No no){
    if (no == null) {
        return;
    }
    imprimir(no.esquerdo);
    System.out.print(no.produto.nome+" ,");
    imprimir(no.direito); 
  }

  public void extremos(){
      No menor=raiz;
      No maior=raiz;
    if(raiz==null){
      System.out.println("Árvore vazia");
    }else{
      while(menor.esquerdo!=null){
        menor = menor.esquerdo;
      }
      while(maior.direito!=null){
        maior=maior.direito;
      }
    }
    System.out.println("Menor: " + menor.produto.nome);
    System.out.println("Maior: " + maior.produto.nome);
  }

}
