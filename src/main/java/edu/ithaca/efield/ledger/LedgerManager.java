package edu.ithaca.efield.ledger;

import java.util.HashMap;
import java.util.Map;

public class LedgerManager {

  private static final LedgerManager INSTANCE = new LedgerManager();

  private Map<String, Ledger> ledgerMap;

  private LedgerManager() {
    this.ledgerMap = new HashMap<>();
  }

  public static LedgerManager getInstance() {
    return INSTANCE;
  }

}
