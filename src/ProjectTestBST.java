import java.io.*;

//this class is all ab reading the file
//line 48
class ProjectTestBST {
  BufferedReader fileReader;
  BST<String> bst;

  public static void main(String[] args) {
    // how to make file get read when we dont have to use absolute path
    ProjectTestBST Test = new ProjectTestBST(
        ".vscode/datafile.txt");
    Test.bst.inorder();
    Test.bst.search("database");
    Test.bst.search("spatial");
  }

  public ProjectTestBST(String filename) {
    try {
      bst = new BST<String>();
      fileReader = new BufferedReader(new FileReader(filename));
      while (readNextRecord()) {
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public boolean readNextRecord() {
    if (fileReader == null) {
      System.out.println("Error: You must open the file first.");
      return false;
    } else {
      try {
        String data = fileReader.readLine();
        if (data == null)
          return false;
        int titleId = Integer.parseInt(data);
        String title = fileReader.readLine();
        String author = fileReader.readLine();
        int numKeys = Integer.parseInt(fileReader.readLine());
        Article article = new Article(titleId, title, author);

        String keyword;
        for (int i = 0; i < numKeys; i++) {
          keyword = fileReader.readLine();
          bst.insert(keyword, article);

          if (keyword.compareTo("database") == 0) {
            System.out.println(article);
          }

        }
        // we can add testing for space later; for now read the blank line
        fileReader.readLine();
      } catch (NumberFormatException e) {
        System.out.println("Error: Number expected!");
        return false;
      } catch (Exception e) {
        System.out.println("Fatal Error: " + e);
        return false;
      }
      return true;
    }
  }
}