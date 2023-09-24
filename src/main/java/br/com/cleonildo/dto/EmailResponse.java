package br.com.cleonildo.dto;

import java.time.Instant;

public record EmailResponse(String message, Instant timestemp) { }
