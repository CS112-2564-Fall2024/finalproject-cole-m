package edu.miracosta.cs112.finalproject.finalproject;

import edu.miracosta.cs112.finalproject.finalproject.Pokemons.Chimchar;

abstract class Player {
    private Pokemon[] pokemons;
    private Pokemon currentPokemon;
    private int pokemonCount;
    private int potionsCount;

    public Player(Pokemon[] pokemons, int pokemonCount, int potionsCount) {
        this.setAll(pokemons, pokemons[0], pokemonCount, potionsCount);
    }

    public Player() {
        this.setAll(new Pokemon[6], new Chimchar(), 1, 5);
    }

    public Player(Player copy) {
        this.setAll(copy.pokemons, copy.currentPokemon, copy.pokemonCount, copy.potionsCount);
    }

    public void setPokemons(Pokemon[] pokemons) {
        if (pokemons != null && pokemons.length <= 6) {
            this.pokemons = pokemons;
            this.setPokemonCount(pokemons.length);
        }
    }

    public void setCurrentPokemon(Pokemon currentPokemon) {
        this.currentPokemon = currentPokemon;
    }

    public void setPokemonCount(int pokemonCount) {
        if (pokemonCount >= 0 && pokemonCount <= 6) {
            this.pokemonCount = pokemonCount;
        }
    }

    public void setPotionsCount(int potionsCount) {
        if (potionsCount >= 0) {
            this.potionsCount = potionsCount;
        }
    }

    public void setAll(Pokemon[] pokemons, Pokemon currentPokemon, int pokemonCount, int potionsCount) {
        this.setPokemons(pokemons);
        this.setCurrentPokemon(currentPokemon);
        this.setPokemonCount(pokemonCount);
        this.setPotionsCount(potionsCount);
    }

    public Pokemon[] getPokemons() {
        return this.pokemons;
    }

    public Pokemon getCurrentPokemon() {
        return this.currentPokemon;
    }

    public int getPokemonCount() {
        return this.pokemonCount;
    }

    public int getPotionsCount() {
        return this.potionsCount;
    }

    @Override
    public String toString() {
        String pokemonNames = "";
        for (int i = 0; i < pokemons.length; i++) {
            if (pokemons[i] != null) {
                pokemonNames += pokemons[i].getName();
                if (i < pokemons.length - 1 && pokemons[i + 1] != null) {
                    pokemonNames += ", ";
                }
            }
        }
        return "Player: Pokemons = [" + pokemonNames + "]" +
                ", CurrentPokemon = " + this.currentPokemon +
                ", PokemonCount = " + this.pokemonCount +
                ", PotionsCount = " + this.potionsCount;
    }

    @Override
    public boolean equals(Object other) {
        if(other == null || this.getClass() != other.getClass()) {
            return false;
        } else {
            Player otherPlayer = (Player)other;
            if(!this.currentPokemon.equals(otherPlayer.getCurrentPokemon())) {
                return false;
            }
            if (this.pokemonCount != otherPlayer.pokemonCount) {
                return false;
            }
            if (this.potionsCount != otherPlayer.potionsCount) {
                return false;
            }
            if (this.pokemons == null && otherPlayer.pokemons != null || this.pokemons != null && otherPlayer.pokemons == null) {
                return false;
            }
            if (this.pokemons != null && otherPlayer.pokemons != null) {
                if (this.pokemons.length != otherPlayer.pokemons.length) {
                    return false;
                }
                for (int i = 0; i < this.pokemons.length; i++) {
                    if (!this.pokemons[i].equals(otherPlayer.pokemons[i])) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public abstract Pokemon switchPokemon();

    public abstract void commandAttack(Pokemon opponentPokemon);

    public abstract void healPokemon();
}
