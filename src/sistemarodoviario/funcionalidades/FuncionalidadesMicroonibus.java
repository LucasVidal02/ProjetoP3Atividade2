package sistemarodoviario.funcionalidades;
import sistemarodoviario.objetos.MicroOnibus;

public class FuncionalidadesMicroonibus extends FuncionalidadesOnibus {
    
    private MicroOnibus[] microonibus;
    private int cont;
    private boolean flag;
    
    public FuncionalidadesMicroonibus(){
        
    
        this.cont = 0;
        this.microonibus = new MicroOnibus[15];
    }
    
     public void adicionarOnibus(MicroOnibus m) {
        if (m == null || microonibus.length == cont || procurarMicroonibus(m.getOnibusrotas()) != -1) {
            System.out.println("Não foi possível adicionar o Micro-onibus pois ja existe em nosso sistema!");
        } else {
            this.microonibus[cont] = m;
            cont++;
            System.out.println("Seu micro-onibus foi adicionado com sucesso a sua empresa");
        }
        flag = false;    
    }

     private int procurarMicroonibus(String Onibusrotas) {
        if (flag == true) {
            for (int i = 0; i < cont; i++) {
                if (this.microonibus[i].getOnibusrotas().equals(Onibusrotas)) {
                    return i;
                }
            }
            return -1;
        } else {

            int inicio = 0, fim = this.cont - 1, meio;

            while (inicio <= fim) {
                meio = (inicio + fim) / 2;
                if (this.microonibus[meio].getOnibusrotas().compareToIgnoreCase(Onibusrotas) == 0) {
                    return meio;
                } else if (Onibusrotas.compareToIgnoreCase(this.microonibus[meio].getOnibusrotas()) < 0) {
                    fim = meio - 1;
                } else {
                    inicio = meio + 1;
                }
            }
            return -1;
        }
    }
     
    public void resevarAssento(MicroOnibus m) {
      
       if (m == null || microonibus.length == cont || procurarMicroonibus(m.getOnibusrotas()) != -1) {
            System.out.println("O seu Micro-onibus existe e sua reserva foi feita");
            
        } else {
            this.microonibus[cont] = m;
           System.out.println("Esse Micro-onibus ainda não existe");
        }
      
        flag = false;
    }
    
    
    @Override
    public void exibir() {
        int i;
        for (i = 0; i < this.cont; i++) {
            System.out.println(this.microonibus + " ");
        }
    }

}
