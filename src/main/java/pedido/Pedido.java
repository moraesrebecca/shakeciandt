package pedido;

import ingredientes.Adicional;
import produto.Shake;

import java.util.ArrayList;

public class Pedido {

    private int id;
    private  ArrayList<ItemPedido> itens;
    private Cliente cliente;

    public Pedido(int id, ArrayList<ItemPedido> itens,Cliente cliente) {
        this.id = id;
        this.itens=itens;
        this.cliente=cliente;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public int getId(){
        return this.id;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public double calcularTotal(Cardapio cardapio){
        double total= 0;
        //TODO
        return total;
    }

    public void adicionarItemPedido(ItemPedido itemPedidoAdicionado) {
        int index = this.itens.indexOf(itemPedidoAdicionado);
        if (index < 0) {
            this.itens.add(itemPedidoAdicionado);
        } else {
            ItemPedido itemAtual = this.itens.get(index);
            itemPedidoAdicionado.setQuantidade(itemPedidoAdicionado.getQuantidade() + itemAtual.getQuantidade());
            this.itens.remove(index);
            this.itens.add(itemPedidoAdicionado);
        }
    }

    public boolean removeItemPedido(ItemPedido itemPedidoRemovido) {
        //substitua o true por uma condição
        if (true) {
            //TODO
        } else {
            throw new IllegalArgumentException("Item nao existe no pedido.");
        }
        return false;
    }

    @Override
    public String toString() {
        return this.itens + " - " + this.cliente;
    }
}
