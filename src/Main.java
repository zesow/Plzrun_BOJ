import java.util.ArrayList;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

    static class Plzrun{
        static int[][] problems = {{2557, 1000, 2558, 10950, 10951, 10952, 10953, 11021, 11022, 11718, 11719, 11720, 11721, 2741, 2742, 2739, 1924, 8393, 10818, 2438, 2439, 2440, 2441, 2442, 2445, 2522, 2446, 10991, 1099}
        ,{1463, 11726, 11727, 9095, 10844, 11057, 2193, 9465, 2156, 11053, 11055, 11722, 11054, 1912, 2579, 1699, 2133, 9461, 2225, 2011, 11052} // io
        ,{2751, 11650, 11651, 10814, 10825, 10989, 11652, 11004, 10828, 9012, 10799, 10845, 10866, 10808, 10809, 10820, 2743, 11655, 10824, 11656, 1406, 1158, 1168, 10430, 2609, 1934, 1850, 9613, 11005, 2745, 1373, 1212, 2089, 11576, 1978, 1929, 6588, 11653, 10872, 1676, 2004} // others
        ,{1260, 11724, 1707, 10451, 2331, 9466, 2667, 4963, 7576, 2178, 2146, 1991, 11725, 1167, 1967} // graph
        ,{1654, 2805, 2110, 10815, 10816, 11662} //bs
        ,{11728, 1780, 11729, 1992, 2447, 2448, 1517, 2261} //dc
        ,{11047, 2875, 10610, 1783, 1931, 11399, 2873, 1744} //greedy
        ,{1476, 1107, 1451, 9095, 10819, 10971, 1697, 1963, 9019, 1525, 2251, 2186, 3108, 5014, 1759, 2580, 1987, 6603, 1182, 2003, 1806, 1644, 1261, 1208, 7453, 2632, 2143} // es
        };
    }
    public static void main(String[] args) throws Exception{
        System.out.println("id를 입력하세요");
        Scanner sc = new Scanner(System.in);

        String id = sc.nextLine();

        String url = "https://www.acmicpc.net/user/" + id;

        Document doc = Jsoup.connect(url).get();

        String cssQuery = "div.panel-body span.problem_number a";
        Elements problems = doc.select(cssQuery);

        ArrayList<Integer> solved = new ArrayList<>();


        for(Element e:problems){
            solved.add(Integer.parseInt(e.text()));
        }

        StringBuilder sb = new StringBuilder();
        int allCnt = 0,remainCnt = 0;
        for(int i = 0 ; i < Plzrun.problems.length ; ++i)
        {
            allCnt += Plzrun.problems[i].length;
            switch (i){
                case 0 :
                    sb.append("문자열 : ");
                    break;
                case 1 :
                    sb.append("입출력 : ");
                    break;
                case 2 :
                    sb.append("잡다한것 : ");
                    break;
                case 3 :
                    sb.append("그래프 : ");
                    break;
                case 4 :
                    sb.append("이분탐색 : ");
                    break;
                case 5 :
                    sb.append("분할정복 : ");
                    break;
                case 6 :
                    sb.append("그리디 : ");
                    break;
                case 7 :
                    sb.append("완전탐색 : ");
                    break;
            }
            for(int j = 0 ; j < Plzrun.problems[i].length; ++j)
            {
                int flag = 0;

                for(int k = 0 ; k < solved.size(); ++k)
                {
                    if(Plzrun.problems[i][j] == solved.get(k)){
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0){
                    sb.append(Plzrun.problems[i][j] + " ");
                    remainCnt++;
                }
            }
            sb.append('\n');
        }


        System.out.println(sb);
        System.out.println("***************************");
        System.out.println("총 추천 문제 갯수 : " + allCnt + " 개");
        System.out.println(id + " 의 풀어야할 남은 추천 문제 갯수 : " + remainCnt + " 개");
        System.out.println("***************************");


    }
}
