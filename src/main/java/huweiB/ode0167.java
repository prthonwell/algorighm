package huweiB;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ode0167 {
    static class book {
        int a;
        int b;
        book( int a, int b ) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Pattern p = Pattern.compile( "\\[\\d+,\\d+]" );
        Matcher m = p.matcher( s );
        List<book> books = new ArrayList<book>();
        while ( m.find() ) {
            String cur = m.group();
            cur = cur.substring( 1, cur.length() - 1 );
            String[] ss = cur.split( ",");
            book book = new book( Integer.parseInt( ss[0] ), Integer.parseInt( ss[1] ) );
            books.add( book );
        }
        books.sort((a,b)-> a.a == b.a ? b.b - a.b : b.a - a.a );
        HashMap<book, Integer> dp = new HashMap<book, Integer>();
        int res = dfs(books.get(0), dp, books, 0);
        int index = 1;
        while (index < books.size()) {
            if (books.get(index).a != books.get(index-1).a){
                res = Math.max(res, dfs(books.get(index), dp, books, index));
            }
            index++;
        }
        sc.close();
        System.out.println(res);
    }

    private static int dfs(book b, HashMap<book, Integer> dp, List<book> books, int i) {
        if (dp.containsKey(b)) {
            return dp.get(b);
        }
        int res = 0;
        for (int j = i + 1; j < books.size(); j++) {
            book cur = books.get(j);
            if (cur.b < b.b && cur.a < b.a) {
                res = Math.max(res, dfs(books.get(j), dp, books, j));
            }
        }
        dp.put(b, res + 1);
        return res + 1;
    }
}
