package edu.miracosta.cs112.finalproject.finalproject;

public class Player {
    private Pokemon[] pokemons;
    private int pokemonCount;
    private int potionsCount;

    public Player(Pokemon[] pokemons, int pokemonCount, int potionsCount) {
        this.setAll(pokemons, pokemonCount, potionsCount);
    }

    public Player() {
        this.setAll(new Pokemon[6], 0, 5);
    }

    public Player(Player copy) {
        this.setAll(copy.pokemons, copy.pokemonCount, copy.potionsCount);
    }

    public void setPokemons(Pokemon[] pokemons) {
        if (pokemons != null && pokemons.length <= 6) {
            this.pokemons = pokemons;
            this.setPokemonCount(pokemons.length);
        }
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

    public void setAll(Pokemon[] pokemons, int pokemonCount, int potionsCount) {
        this.setPokemons(pokemons);
        this.setPokemonCount(pokemonCount);
        this.setPotionsCount(potionsCount);
    }

    public Pokemon[] getPokemons() {
        return pokemons;
    }

    public int getPokemonCount() {
        return this.pokemonCount;
    }

    public int getPotionsCount() {
        return this.potionsCount;
    }

    public void healPokemon(Pokemon pokemon) {
        //TODO: heal pokemon using Potion class
        if(potionsCount > 0) {
            if(pokemon.getHp() > 0) {
                if((pokemon.getHp() + 50) > pokemon.getMaxHP()){
                    System.out.println(pokemon.getName() + " HP was originally " + pokemon.getHp());
                    pokemon.setHp(pokemon.getMaxHP());
                    System.out.println("And was healed to max HP of "  + pokemon.getHp());
                } else {
                    pokemon.setHp(pokemon.getHp() + 50);
                    System.out.println(pokemon.getName() + " was healed to a HP of " + pokemon.getHp());
                }
            } else {
                System.out.println(pokemon.getName() + " is knocked out");
            }
        } else {
            System.out.println("You are out of potion!");
        }
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
                ", PokemonCount = " + this.pokemonCount +
                ", PotionsCount = " + this.potionsCount;
    }

    @Override
    public boolean equals(Object other) {
        if(other == null || this.getClass() != other.getClass()) {
            return false;
        } else {
            Player otherPlayer = (Player)other;
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
}
