import java.util.Scanner;

public class Giorno{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("inserisci data (gg/mm/aaaa):");
        String successivo = giornoSuccessivo(in.nextLine());
        System.out.println("il giorno successivo e' "+successivo);
        in.close();
    }

    static String creaData(int g, int m, int a){
        return g+"/"+m+"/"+a;
    }

    static String giornoSuccessivo(String data){
        String[] dataArr = data.split("/");
        int giorno = Integer.parseInt(dataArr[0]);
        int mese = Integer.parseInt(dataArr[1]);
        int anno = Integer.parseInt(dataArr[2]);

        if(giorno<1||giorno>31||mese<1||mese>12){
            return "data non valida";
        }

        if(giorno == 31){
            switch(mese){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                    return creaData(1, mese+1, anno);
                case 12:
                    return creaData(1, 1, anno+1);
                default:
                    return "data non valida";
            }
        }else if(giorno == 30){
            switch(mese){
                case 4:
                case 6:
                case 9:
                case 11:
                    return creaData(1,mese+1,anno);
                default:
                    break;
            }
        }

        if((anno%4==0&&anno%100!=0)||anno%400==0){
            if(mese==2){
                if(giorno>29){
                    return "data non valida";
                }else if(giorno==29){
                    return creaData(1, mese+1, anno);
                }
            }
        }else{
            if(mese==2){
                if(giorno>28){
                    return "data non valida";
                }else if(giorno==28){
                    return creaData(1, mese+1, anno);
                }
            }
        }

        return creaData(giorno+1, mese, anno);
    }
}
