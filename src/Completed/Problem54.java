package Completed;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Problem54 
{
  public enum HandType {
    HIGH_CARD, ONE_PAIR, TWO_PAIR, THREE_KIND,
    STRAIGHT, FLUSH, FULL_HOUSE, FOUR_KIND,
    STRAIGHT_FLUSH, ROYAL_FLUSH;
  }

  public enum Suite {
    CLUBS, DIAMONDS, HEARTS, SPADES
  }

  static class Hand implements Comparable<Hand> {
    private final HandType handtype;
    private final List<Card> valuecards;
    private final List<Card> extracards;

    public Hand(Card[] cards) {
      this.valuecards = new ArrayList<Card>();
      this.extracards = new ArrayList<Card>();
      this.handtype = getHandType(cards);
      Collections.sort(valuecards, Collections.reverseOrder());
      Collections.sort(extracards, Collections.reverseOrder());
    }

    private HandType getHandType(Card[] cards) {
      int[] valuecounts = new int[13];
      int[] suitecounts = new int[4];

      for (Card card : cards) {
        valuecounts[card.value - 1]++;
        suitecounts[card.suite.ordinal()]++;
      }

      boolean flush = false;
      for (int x = 0; x < 4; x++) {
        flush |= (suitecounts[x] == 5);
      }

      boolean straight = false;
      int count = 0;
      int max = -1;
      for (int x = 0; x < 13; x++) {
        if (valuecounts[x] == 1) {
          count++;
          if (count == 5) {
            max = x;
          }
        } else if (count != 0 || valuecounts[x] != 0) {
          break;
        }
      }
      straight = (count == 5);

      if (flush || straight) {
        for (Card card : cards) {
          valuecards.add(card);
        }
        if (flush && straight) {
          if (max == 12) {
            return HandType.ROYAL_FLUSH;
          } else {
            return HandType.STRAIGHT_FLUSH;
          }
        } else if (flush) {
          return HandType.FLUSH;
        } else if (straight) {
          return HandType.STRAIGHT;
        }
      }

      for (int x = 0; x < 13; x++) {
        if (valuecounts[x] == 4) {
          for (Card card : cards) {
            if (card.value == x + 1) {
              valuecards.add(card);
            } else {
              extracards.add(card);
            }
          }
          return HandType.FOUR_KIND;
        }
        if (valuecounts[x] == 3 || valuecounts[x] == 2) {
          for (Card card : cards) {
            if (card.value == x + 1) {
              valuecards.add(card);
            }
          }
        }
      }
      
      for (Card card : cards) {
        if (!valuecards.contains(card)) {
          extracards.add(card);
        }
      }
      
      if (valuecards.size() == 5) {
        return HandType.FULL_HOUSE;
      } else if (valuecards.size() == 3) {
        return HandType.THREE_KIND;
      } else if (valuecards.size() == 4) {
        return HandType.TWO_PAIR;
      } else if (valuecards.size() == 2) {
        return HandType.ONE_PAIR;
      }

      return HandType.HIGH_CARD;
    }

    @Override
    public int compareTo(Hand hand) {
      int handdiff = handtype.compareTo(hand.handtype);
      if (handdiff != 0) {
        return handdiff;
      } else {
        for (int x = 0; x < valuecards.size(); x++) {
          int valuediff = valuecards.get(x).compareTo(hand.valuecards.get(x));
          if (valuediff != 0) {
            return valuediff;
          }
        }
        for (int x = 0; x < extracards.size(); x++) {
          int extradiff = extracards.get(x).compareTo(hand.extracards.get(x));
          if (extradiff != 0) {
            return extradiff;
          }
        }

        // this should never happen unless there's a true tie
        return 0;
      }
    }
  }

  static class Card implements Comparable<Card> {
    public final int value;
    public final Suite suite;

    public Card(String in) {
      switch (in.charAt(0)) {
        case 'A': this.value = 13; break;
        case 'K': this.value = 12; break;
        case 'Q': this.value = 11; break;
        case 'J': this.value = 10; break;
        case 'T': this.value = 9; break;
        default: this.value = Integer.parseInt(String.valueOf(in.charAt(0))) - 1;
      }
      switch (in.charAt(1)) {
        case 'C': this.suite = Suite.CLUBS; break;
        case 'D': this.suite = Suite.DIAMONDS; break;
        case 'H': this.suite = Suite.HEARTS; break;
        case 'S': this.suite = Suite.SPADES; break;
        default: throw new RuntimeException("Invalid Suite");
      }
    }

    @Override
    public int compareTo(Card card) {
      return value - card.value;
    }
    
    @Override
    public boolean equals(Object obj) {
      if (obj instanceof Card) {
        Card card = (Card) obj;
        return (value == card.value) && (suite == card.suite);
      } else {
        return false;
      }
    }
  }

  public URL input = Problem54.class.getResource("/poker.txt");

  public Problem54() throws Exception
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(input.openStream()));

    int count = 0;
    String nextline;
    while ((nextline = br.readLine()) != null) {
      String[] dat = nextline.split(" ");

      Card[] p1cards = new Card[5];
      Card[] p2cards = new Card[5];

      for (int x = 0; x < 5; x++) {
        p1cards[x] = new Card(dat[x]);
        p2cards[x] = new Card(dat[x + 5]);
      }

      Hand player1 = new Hand(p1cards);
      Hand player2 = new Hand(p2cards);

      if (player1.compareTo(player2) > 0) {
        count++;
      }
    }
    System.out.println(count);

    br.close();
  }

  public static void main(String[] args) throws Exception
  {
    new Problem54();
  }
}
