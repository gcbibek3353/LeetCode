/**
 * @param {number} n - Total number of players
 * @param {number} firstPlayer - First important player
 * @param {number} secondPlayer - Second important player
 * @return {number[]} - Array containing the earliest and latest round where both players meet
 */
function earliestAndLatest(n: number, firstPlayer: number, secondPlayer: number): number[] {
  let earliest: number = n; // Initialize the earliest round to the maximum possible
  let latest: number = 0;   // Initialize the latest round to 0

  const visited: Set<number> = new Set(); // Track visited game states to avoid repetition

  // Recursive function to simulate rounds
  const findRounds = (remain: number, players: number[], currentIndex: number, round: number): void => {
    // If this state has already been visited, return early
    if (visited.has(remain)) return;

    const player = players[currentIndex];                    // Current player in the matchup
    const opponent = players[players.length - currentIndex];  // Opponent from the other end

    // If firstPlayer and secondPlayer face each other, update earliest and latest round numbers
    if ((player === firstPlayer && opponent === secondPlayer) ||
        (player === secondPlayer && opponent === firstPlayer)) {
      earliest = Math.min(earliest, round);
      latest = Math.max(latest, round);
      return;
    }

    // If all matchups are completed for this round, move to the next round
    if (opponent <= player) {
      const nextPlayers = players.filter(p => remain & (1 << p)); // Filter advancing players
      findRounds(remain, nextPlayers, 1, round + 1); // Recurse for the next round
      return;
    }

    // Simulate both outcomes where player or opponent wins
    const remainIfPlayerWins = remain ^ (1 << opponent);  // Player wins, opponent eliminated
    const remainIfOpponentWins = remain ^ (1 << player);  // Opponent wins, player eliminated
    const nextIndex = currentIndex + 1;

    // Recursion based on which player is important
    if (player === firstPlayer || player === secondPlayer) {
      findRounds(remainIfPlayerWins, players, nextIndex, round);
      return;
    }
    if (opponent === firstPlayer || opponent === secondPlayer) {
      findRounds(remainIfOpponentWins, players, nextIndex, round);
      return;
    }

    // Recurse for both outcomes
    findRounds(remainIfPlayerWins, players, nextIndex, round);
    findRounds(remainIfOpponentWins, players, nextIndex, round);

    // Mark the current state as visited
    visited.add(remain);
  };

  // Create a list of players (1-indexed)
  const players: number[] = Array.from({ length: n + 1 }, (_, i) => i);

  // Bitmask to represent all players remaining
  const ALL_PLAYERS_REMAIN = (1 << (n + 1)) - 1;

  // Start the search from the first round
  findRounds(ALL_PLAYERS_REMAIN, players, 1, 1);

  // Return the earliest and latest round where the two players meet
  return [earliest, latest];
}