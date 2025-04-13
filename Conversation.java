import java.util.*;

class Conversation implements Chatbot {

  // Attributes
  private ArrayList<String> transcript = new ArrayList<>();
  private Scanner scanner = new Scanner(System.in);
  private Random random = new Random();

  /**
   * Constructor
   */
  Conversation() {
    // No specific setup needed here
  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
    System.out.print("How many rounds? ");
    int rounds = Integer.parseInt(scanner.nextLine());

    String greeting = "Hi there! What's on your mind?";
    System.out.println(greeting);
    transcript.add(greeting);

    for (int i = 0; i < rounds; i++) {
      String userInput = scanner.nextLine();
      transcript.add(userInput);

      String response = respond(userInput);
      System.out.println(response);
      transcript.add(response);
    }

    String goodbye = "See ya!";
    System.out.println(goodbye);
    transcript.add(goodbye);
  }

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {
    System.out.println("\nTRANSCRIPT:");
    for (String line : transcript) {
      System.out.println(line);
    }
  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the user's last line of input
   * @return mirrored or canned response to user input
   */
  public String respond(String inputString) {
    String[] words = inputString.split("\\s+");
    StringBuilder mirroredResponse = new StringBuilder();
    boolean mirroredUsed = false;

    for (String word : words) {
      switch (word.toLowerCase()) {
        case "i":
          mirroredResponse.append("you ");
          mirroredUsed = true;
          break;
        case "me":
          mirroredResponse.append("you ");
          mirroredUsed = true;
          break;
        case "am":
          mirroredResponse.append("are ");
          mirroredUsed = true;
          break;
        case "you":
          mirroredResponse.append("I ");
          mirroredUsed = true;
          break;
        case "my":
          mirroredResponse.append("your ");
          mirroredUsed = true;
          break;
        case "your":
          mirroredResponse.append("my ");
          mirroredUsed = true;
          break;
        default:
          mirroredResponse.append(word).append(" ");
          break;
      }
    }

    if (mirroredUsed) {
      return mirroredResponse.toString().trim() + "?";
    } else {
      return getRandomCannedResponse();
    }
  }

  private String getRandomCannedResponse() {
    String[] cannedResponses = {
      "Mmm-hm.", "Tell me more.", "Interesting...", 
      "Go on.", "Why do you say that?"
    };
    return cannedResponses[random.nextInt(cannedResponses.length)];
  }

  /**
   * Main method to start the conversation
   */
  public static void main(String[] arguments) {
    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();
  }
}

