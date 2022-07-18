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

    public double calcularTotal(Cardapio cardapio) {
        double total= 0;
        for(ItemPedido item: itens) {
            double valorItem = 0;
            Shake shake = item.getShake();
            valorItem += (cardapio.buscarPreco(shake.getBase()) * shake.getTipoTamanho().multiplicador);
            for (Adicional adicional: shake.getAdicionais()) {
                valorItem += cardapio.buscarPreco(adicional);
            }
            valorItem *= item.getQuantidade();
            total += valorItem ;
        }
        return total;
    }

    public void adicionarItemPedido(ItemPedido itemPedidoAdicionado) {
        int index = this.itens.indexOf(itemPedidoAdicionado);
        if (index < 0) {
            this.itens.add(itemPedidoAdicionado);
        } else {
            ItemPedido itemAtual = this.itens.get(index);
            itemPedidoAdicionado.setQuantidade(itemPedidoAdicionado.getQuantidade() + itemAtual.getQuantidade());
            this.itens.set(index, itemPedidoAdicionado);
        }
    }

    public boolean removeItemPedido(ItemPedido itemPedidoRemovido) {
        int index = itens.indexOf(itemPedidoRemovido);
        if (index >= 0) {
            ItemPedido itemAtual = itens.get(index);
            this.itens.remove(index);
            if (itemAtual.getQuantidade() > 1) {
                itemAtual.setQuantidade(itemAtual.getQuantidade() - 1);
                this.itens.add(itemAtual);
            }
            return true;
        } else {
            throw new IllegalArgumentException("Item nao existe no pedido.");
        }
    }

    @Override
    public String toString() {
        return this.itens + " - " + this.cliente;
    }
}
