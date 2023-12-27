public class Main {
    public static void main(String[] args) {
        // Test Case 0
        SuffixTree t0 = new SuffixTree("bananabanaba$");
        System.out.println("Test Case 0:");
        System.out.print("Search for 'ana': ");
        t0.search("ana"); // Prints: 1 3 7
        System.out.print("Search for 'naba': ");
        t0.search("naba"); // Prints: 4 8
        System.out.println();

        // Test Case 1
        SuffixTree t1 = new SuffixTree("programming$");
        System.out.println("Test Case 1:");
        System.out.print("Search for 'gram': ");
        t1.search("gram"); // Prints: 3
        System.out.print("Search for 'pro': ");
        t1.search("pro"); // Prints: 0
        System.out.print("Search for 'ing': ");
        t1.search("ing"); // Prints: 8
        System.out.println();
    }
}