const wordList = ["apple", "banana", "grape", "mango", "peach", "orange", "kiwi"];
let secretWord = "";
let maxTries = 5;
let triesLeft = maxTries;

const guessInput = document.getElementById("guessInput");
const message = document.getElementById("message");
const attemptsLeft = document.getElementById("attemptsLeft");
const restartBtn = document.getElementById("restartBtn");
const hintText = document.getElementById("hintText");

function startGame() {
  secretWord = wordList[Math.floor(Math.random() * wordList.length)];
  console.log("Secret word:", secretWord); // for testing
  triesLeft = maxTries;

  guessInput.disabled = false;
  message.textContent = "";
  attemptsLeft.textContent = `Attempts left: ${triesLeft}`;
  hintText.textContent = `Hint: The word starts with "${secretWord[0].toUpperCase()}"`;
  restartBtn.style.display = "none";
  document.body.style.backgroundColor = "#f4f4f4";
  guessInput.value = "";
  guessInput.focus();
}

function submitGuess() {
  if (triesLeft <= 0) return;

  const userGuess = guessInput.value.trim().toLowerCase();

  if (userGuess === "") {
    triesLeft--;
    message.textContent = `⚠️ Empty input! ${triesLeft} attempts left.`;
  } else if (userGuess === secretWord) {
    message.textContent = "🎉 Congratulations! You guessed the secret word!";
    document.body.style.backgroundColor = "#d4edda";
    endGame();
    return;
  } else {
    triesLeft--;
    if (triesLeft > 0) {
      message.textContent = `❌ Incorrect guess. ${triesLeft} attempts left.`;
    } else {
      message.textContent = `💀 Game over! The secret word was "${secretWord}".`;
      document.body.style.backgroundColor = "#f8d7da";
    }
  }

  attemptsLeft.textContent = `Attempts left: ${triesLeft}`;
  guessInput.value = "";

  if (triesLeft <= 0) endGame();
}

function endGame() {
  guessInput.disabled = true;
  restartBtn.style.display = "inline-block";
}

guessInput.addEventListener("keydown", function (e) {
  if (e.key === "Enter") submitGuess();
});

// Initialize game on load
startGame();