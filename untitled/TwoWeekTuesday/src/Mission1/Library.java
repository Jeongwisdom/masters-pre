package Mission1;

import java.util.Arrays;

class Book {
    String title;
    String author;

    Book() {}

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    static void Printlist(Book book[], String library) {
        System.out.println("----------" + library + " 책 목록----------");
        for(int i = 0; i < book.length; i++){
            System.out.println("[" + book[i].title + "| " + book[i].author + "]");
        }
        System.out.println();
    }
}

public class Library {
    public static void main(String[] args) {
        Book[] A = new Book[5];
        A[0] = new Book("태백산맥", "조정래");
        A[1] = new Book("이기적 유전자", "리커드 도킨스");
        A[2] = new Book("자전거 도둑", "박완서");
        A[3] = new Book("토지", "박경리");
        A[4] = new Book("대변동", "제레드 다이아몬드");
        Book[] A1 = A;
        Book[] B = new Book[A.length];
        for(int i = 0; i < A.length; i++) {
            B[i] = new Book(A[i].title, A[i].author);
        }
        String Alibrary = "온마을 도서관";
        String A1library = "온마을 도서관 복사본";
        String Blibrary = "두마을 도서관";

        Book.Printlist(A, Alibrary);
        Book.Printlist(A1, A1library);
        Book.Printlist(B, Blibrary);

        A[2].title = "그 많던 싱아는 누가 다 먹었을까";
        int BLength = B.length;
        Book[] newB = Arrays.copyOf(B, BLength + 1);
        newB[BLength] = new Book("사피엔스", "유발 하라리");

        Book.Printlist(A, Alibrary);
        Book.Printlist(A1, A1library);
        Book.Printlist(newB, Blibrary);
    }
}
