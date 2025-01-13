import com.easycm.easymanager.model.Venda;
import com.easycm.easymanager.model.Material;


import java.util.List;

public class RelatorioService {

    public void gerarRelatorioFinanceiro(List<Venda> vendas) {
        double totalVendas = vendas.stream().mapToDouble(Venda::getValorTotal).sum();
        double totalDespesas = vendas.stream()
                .flatMap(venda -> venda.getMateriais().stream())
                .mapToDouble(Material::calcularCusto).sum();

        double lucro = totalVendas - totalDespesas;

        System.out.println("Relatório Financeiro:");
        System.out.println("Total de Vendas: " + totalVendas);
        System.out.println("Total de Despesas: " + totalDespesas);
        System.out.println("Lucro: " + lucro);
    }
}
