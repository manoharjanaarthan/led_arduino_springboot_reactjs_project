const int RED_LED = 8;
const int GREEN_LED = 12;

void setup() {

  pinMode(RED_LED, OUTPUT);
  pinMode(GREEN_LED, OUTPUT);

}

void loop() {

  digitalWrite(RED_LED, HIGH);
  digitalWrite(GREEN_LED, LOW);

  delay(1000);

  digitalWrite(RED_LED, LOW);
  digitalWrite(GREEN_LED, HIGH);

  delay(1000);

}