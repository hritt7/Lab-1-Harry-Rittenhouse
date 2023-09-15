/**
 * A counter that will roll over to the min
 * value when attempting to increase it beyond the maximum value and to the max
 * value when attempting   to decrease it below the min value
 * 
 * @author Charles Hoot 
 * @version 4.0
 */
public class Counter {
    private int value;
    private final int min;
    private final int max;
    private boolean isRoll;
 
    public Counter() {
        this.min = 0;
        this.max = Integer.MAX_VALUE;
        this.value = this.min;
    }


    
    public Counter(int min, int max) {
        if (min >= max) {
            throw new CounterInitializationException("MIN_VALUE must be less than MAX_VALUE");
        }
        this.min = min;
        this.max = max;
        this.value = min;
    }

    
 
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        Counter other = (Counter) otherObject;
        
        
        return value == other.value && min == other.min && max == other.max;
    }

    
    public void increase() {
    if (value == max) {
        value = min;
        isRoll = true;
    } else {
        value++;
        isRoll = false; 
    }
}

   public void decrease() {
    if (value == min) {
        value = max;
        isRoll = true;
    } else {
        value--;
        isRoll = false;
    }
}




   
    public int value() {
        return value;
    }
    public boolean rolledOver() {
       return isRoll;
    }
    public String toString() {
        return "Counter: value=" + value + " min=" + min + " max=" + max + " rolledOver=" + rolledOver();
    }
}
