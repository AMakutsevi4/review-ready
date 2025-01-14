CREATE TABLE IF NOT EXISTS bank_profit (
    id SERIAL PRIMARY KEY,
    profit_rub DOUBLE PRECISION NOT NULL,
    transaction_time TIMESTAMP
);

