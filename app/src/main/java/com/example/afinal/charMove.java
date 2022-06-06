package com.example.afinal;

public class charMove
{
    String move;
    String damage;

    public charMove(String newMove, String newDamage)
    {
        String move = newMove;
        String damage = newDamage;
    }

    public charMove(String newMove)
    {
        String move = newMove;
    }

    public String getMove()
    {
        return move;
    }

    public String getDamage()
    {
        return damage;
    }
}
