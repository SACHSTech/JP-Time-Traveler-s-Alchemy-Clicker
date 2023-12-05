import processing.core.PApplet;
import processing.core.PImage;

public class TTAC extends PApplet {

    PImage imgLayout;

    int frameCount;

    int intMysticalScribes = 0;
    int intAlchemyAprentices = 0;
    int intTemporalObservations = 0;
    int intEnchantedAlembics = 0;
    int intCelestialCatalysts = 0;
    int intGuardiansOfTheLab = 0;
    int intEraLinkingConduit = 0;
    int intAlchemyAutomatons = 0;
    int intAetherialAmplifiers = 0;
    int intChronoKeepers = 0;

    int intPotionsBrewed = 0;
    float fltEssense = 0;
    
    
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
        imgLayout = loadImage("Layout.png");
        imgLayout.resize(width, height);
    }

    public void draw() {
        background(220);
  
        // Alchemy Table
        drawAlchemyTable((float)(width / 6.5), (float)(height / 2.5));
        
        // Display fltEssense
        fill(0);
        textSize(20);
        text("fltEssense: " + fltEssense, 20, 30);
        
        // Display Potions Brewed
        text("Potions Brewed: " + intPotionsBrewed, 20, 60);

        image(imgLayout, 0, 0);

        calculateUpgrades();
        updateUpgrades();
    }

    public void calculateUpgrades() {

        frameCount ++;

        if (frameCount == 60) {

            frameCount = 0;
            fltEssense += intMysticalScribes;
            
            if (mousePressed) {

                fltEssense += intAlchemyAprentices;

            }
        }
    }

    public void updateUpgrades() {
        if (frameCount == 60) {

            frameCount = 0;
            
        }
            
    }

    public void drawAlchemyTable(float x, float y) {
        // Draw the alchemy table
        fill(150, 75, 0); // Brown color
        rect(x - 150, y - 100, 300, 200);
        
        // Draw mystical ingredients on the alchemy table
        fill(255, 0, 0); // Red color
        ellipse(x - 50, y - 50, 50, 50); // Ingredient 1
        fill(0, 255, 0); // Green color
        ellipse(x + 50, y - 50, 50, 50); // Ingredient 2
    }

    public void mousePressed() {
        
        // Check if the click is on the alchemy table
        if (mouseX > (float)(width / 6.5) - 150 && mouseX < (float)(width / 6.5) + 150 && mouseY > (float)(height / 2.5) - 100 && mouseY < (float)(height / 2.5) + 100) {
            // Clicking on the alchemy table generates fltEssense
            fltEssense++;

            // Update the display
            redraw();
        }

    }

}
