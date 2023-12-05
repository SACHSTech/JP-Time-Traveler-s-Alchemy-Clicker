import processing.core.PApplet;
import processing.core.PImage;

public class TTAC extends PApplet {

    int frameCount;

    int mysticalScribes = 0;
    int alchemyAprentices = 0;
    int temporalObservations = 0;
    int enchantedAlembics = 0;
    int celestialCatalysts = 0;
    int guardiansOfTheLab = 0;
    int eraLinkingConduit = 0;
    int alchemyAutomatons = 0;
    int aetherialAmplifiers = 0;
    int chronoKeepers = 0;

    int potionsBrewed = 0;
    float essence = 0;
    
    
    /**
     * Sets the size of the window.
     */
    public void settings() {
        size(1280, 720);
    }

    /**
     * Initializes the game state and loads necessary resources.
     */
    public void setup() {

    }

    public void draw() {
        background(220);
  
        // Alchemy Table
        drawAlchemyTable(width / 6, (float)(height / 2.5));
        
        // Display Essence
        fill(0);
        textSize(20);
        text("Essence: " + essence, 20, 30);
        
        // Display Potions Brewed
        text("Potions Brewed: " + potionsBrewed, 20, 60);
        calculateUpgrades();
        updateUpgrades();
    }

    public void calculateUpgrades() {

        frameCount ++;

        if (frameCount == 60) {

            frameCount = 0;
            essence += mysticalScribes;
            
            if (mousePressed) {

                essence += alchemyAprentices;

            }
        }
    }

    public void updateUpgrades() {
        if (frameCount == 60) {

            frameCount = 0;
            
        }
            
    }

    void drawAlchemyTable(float x, float y) {
        // Draw the alchemy table
        fill(150, 75, 0); // Brown color
        rect(x - 150, y - 100, 300, 200);
        
        // Draw mystical ingredients on the alchemy table
        fill(255, 0, 0); // Red color
        ellipse(x - 50, y - 50, 50, 50); // Ingredient 1
        fill(0, 255, 0); // Green color
        ellipse(x + 50, y - 50, 50, 50); // Ingredient 2
    }

    void collectingEssence() {
      // Check if the click is on the alchemy table
        if (mouseX > width / 2 - 150 && mouseX < width/ 2 + 150 && mouseY > height / 2 - 100 && mouseY < height / 2 + 100) {
            // Clicking on the alchemy table generates essence
            essence++;

            // Update the display
            redraw();
        }
    }

}
