package Interfaces;

import Exceptions.IHaveNoPlate;
import Objects.Item.Pan;

public interface PutPorridge {
    public void putInPlate(Pan pan) throws IHaveNoPlate;
}
