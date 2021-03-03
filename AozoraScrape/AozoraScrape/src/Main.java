/**
 * Written by Lex Whalen
 */


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        String[] URLArr = 
        {"https://www.aozora.gr.jp/index_pages/person1234.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1742.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1903.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1421.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1582.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1872.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person479.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person2089.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1245.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person380.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1351.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person398.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1468.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person919.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1537.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person506.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1907.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person510.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person179.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person245.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person51.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1127.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1751.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person249.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1059.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1147.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1763.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person989.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person594.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person111.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person133.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1248.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1985.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person2007.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1508.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person577.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person621.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person35.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person275.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1557.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1499.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1362.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1697.html",
        "https://www.aozora.gr.jp/index_pages/person1179.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1184.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1780.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1228.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person718.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1637.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1943.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1163.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1061.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1153.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1910.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1490.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1341.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person939.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1359.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person900.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person343.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person293.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1396.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person303.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1233.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1752.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person927.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1054.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person940.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person2008.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1719.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person351.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1231.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person104.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1447.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person928.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person308.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1676.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person305.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1408.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1481.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person13.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1391.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person319.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person370.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person2123.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1080.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1659.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1515.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person831.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1177.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1177.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person321.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1937.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person325.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person331.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1072.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person163.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1395.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person1501.html#sakuhin_list_1",
        "https://www.aozora.gr.jp/index_pages/person162.html#sakuhin_list_1"};



    AuthorManager manager = new AuthorManager(URLArr);

    //manager.createIndividualCSVs();

    manager.createMassiveCSV();

    //manager.summary();

    /*
    *Note, can also create CSVs / summaries for individual authors
    */

    //Author author = new Author("https://www.aozora.gr.jp/index_pages/person1234.html#sakuhin_list_1");
    //author.createCSV();
    //author.summary();

    System.out.println("Done");
    }
}