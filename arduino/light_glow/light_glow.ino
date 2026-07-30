const int RED_PIN = 8;
const int GREEN_PIN = 9;
const int BLUE_PIN = 10;

void setup() {

  pinMode(RED_PIN, OUTPUT);
  pinMode(GREEN_PIN, OUTPUT);
  pinMode(BLUE_PIN, OUTPUT);

  Serial.begin(9600);

}

void loop() {

  if (Serial.available()) {

    String command = Serial.readStringUntil('\n');

    command.trim();

    if (command == "RED_ON")
      digitalWrite(RED_PIN, HIGH);

    else if (command == "RED_OFF")
      digitalWrite(RED_PIN, LOW);

    else if (command == "GREEN_ON")
      digitalWrite(GREEN_PIN, HIGH);

    else if (command == "GREEN_OFF")
      digitalWrite(GREEN_PIN, LOW);

    else if (command == "BLUE_ON")
      digitalWrite(BLUE_PIN, HIGH);

    else if (command == "BLUE_OFF")
      digitalWrite(BLUE_PIN, LOW);

  }

}