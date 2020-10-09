public class Main {
    public static void main(String[] args) {
       GameState state =  new GameState();
       new Configure().AIConfig(state);
       state.Start();
    }
}
