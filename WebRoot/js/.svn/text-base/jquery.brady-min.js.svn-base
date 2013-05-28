jQuery(function(a) {
	if (!a.brady) {
		a.brady = {}
	}
	a.brady.util = {
		checkAll : function(b) {
			a("#" + b).click(
					function(c) {
						a(":checkbox").not(this).attr("checked",
								a(this).attr("checked"))
					})
		},
		tooltip : function(g, f, d) {
			var c = a("#" + g);
			var b = "promptContainerId__" + new Date().getTime();
			var e = document.getElementById(b);
			if (!e) {
				a(document.body)
						.append(
								"<span id='" + b
										+ "' class='prompt_container'></span>");
				e = document.getElementById(b)
			}
			e = a(e);
			if (d) {
				e.css("width", d + "px")
			}
			c.mouseover(function(h) {
				e.css("left", h.clientX + 10 + "px");
				e.css("top", h.clientY + 10 + "px");
				e.html(f);
				e.show()
			});
			c.mouseout(function(h) {
				e.hide();
				e.html("")
			})
		},
		toFixedWidth : function(g, d, f) {
			var b = g.toString();
			if (!f) {
				f = "0"
			}
			var e = d - b.length;
			if (e < 0) {
				b = b.substring(-e)
			} else {
				for ( var c = 0; c < e; c++) {
					b = f + b
				}
			}
			return b
		},
		formatDate : function(d, f) {
			var i = /yy(yy)?|(M)?M|d?d|HH?|hh?|mm?|ss?|S/;
			var g = {
				yyyy : function(j) {
					return j.getFullYear().toString()
				},
				yy : function(j) {
					return a.brady.util.toFixedWidth(j.getFullYear(), 2)
				},
				MM : function(j) {
					return a.brady.util.toFixedWidth(j.getMonth() + 1, 2)
				},
				M : function(j) {
					return j.getMonth() + 1
				},
				dd : function(j) {
					return a.brady.util.toFixedWidth(j.getDate(), 2)
				},
				d : function(j) {
					return j.getDate()
				},
				HH : function(j) {
					return a.brady.util.toFixedWidth(j.getHours(), 2)
				},
				H : function(j) {
					return j.getHours()
				},
				hh : function(k) {
					var j = k.getHours();
					return a.brady.util.toFixedWidth(j > 12 ? j - 12 : j, 2)
				},
				h : function(j) {
					return j.getHours() % 12
				},
				mm : function(j) {
					return a.brady.util.toFixedWidth(j.getMinutes(), 2)
				},
				m : function(j) {
					return j.getMinutes()
				},
				ss : function(j) {
					return a.brady.util.toFixedWidth(j.getSeconds(), 2)
				},
				s : function(j) {
					return j.getSeconds()
				},
				SSS : function(j) {
					return a.brady.util.toFixedWidth(j.getMilliseconds(), 3)
				}
			};
			var c = [];
			while (f.length > 0) {
				i.lastIndex = 0;
				var b = i.exec(f);
				if (b) {
					var h = f.indexOf(b[0]);
					if (h != 0) {
						var e = f.substring(0, h);
						c.push(e);
						f = f.substring(h)
					}
					c.push(g[b[0]].call(this, d));
					f = f.slice(b[0].length)
				} else {
					c.push(f.charAt(0));
					f = f.slice(1)
				}
			}
			return c.join("")
		},
		getByteCount : function(d) {
			if (!d) {
				return 0
			}
			var b = 0;
			for ( var c = 0; c < d.length; c++) {
				if (d.charCodeAt(c) > 255) {
					b += 2
				} else {
					b++
				}
			}
			return b
		},
		addBookmark : function() {
			var d = document.title;
			var b = document.location.href;
			var c = (navigator.userAgent.toLowerCase()).indexOf("mac") != -1 ? "Command/Cmd + D"
					: "CTRL + D";
			if (document.all) {
				window.external.addFavorite(b, d)
			} else {
				if (window.sidebar) {
					window.sidebar.addPanel(d, b, "")
				} else {
					alert("Try using shortcut key [" + c + "] to operate")
				}
			}
		}
	};
	a.brady.validator = {
		createSpanAfter : function(e, b) {
			var c = document.getElementById(e);
			if (!c) {
				a(b).after("<span id='" + e + "'></span>");
				c = document.getElementById(e)
			}
			var d = a(c);
			return d
		},
		setStyle : function(c, b) {
			c.removeClass("validator_text_tips");
			c.removeClass("validator_fail_tips");
			c.removeClass("validator_succ_tips");
			if (b == "text") {
				c.addClass("validator_text_tips")
			} else {
				if (b == "fail") {
					c.addClass("validator_fail_tips")
				} else {
					if (b == "succ") {
						c.addClass("validator_succ_tips")
					}
				}
			}
		},
		setBorder : function(c, b) {
			c.removeClass("validator_focus_border");
			c.removeClass("validator_fail_border");
			if (b == "focus") {
				c.addClass("validator_focus_border")
			} else {
				if (b == "fail") {
					c.addClass("validator_fail_border")
				}
			}
		},
		needValidate : function(b, d) {
			var e = b.id;
			if (!e) {
				return false
			}
			for ( var c in d) {
				if (c == e) {
					return true
				}
			}
			return false
		},
		validateItemOnBlur : function(d, c) {
			var e = d.nodeName;
			var b = a(e + " input,select,textarea");
			b.each(function(g, f) {
				if (!a.brady.validator.needValidate(f, c)) {
					return
				}
				a(f).focus(function(n) {
					var i = a(f).val();
					if (a.trim(i).length > 0) {
						a.brady.validator.setBorder(a(f), "focus");
						return
					}
					a(f).addClass("validator_focus_border");
					var h = a(f).attr("id");
					var m = c[h].refer;
					var l = h;
					if (m) {
						l = m
					}
					var o = c[l].text;
					if (!o || a.trim(o) == "") {
						return
					}
					var k;
					var p = c[l].msg_panel_id;
					if (p) {
						k = a("#" + p)
					} else {
						var j = "fail_span_id_" + h;
						k = a.brady.validator.createSpanAfter(j, f)
					}
					k.html(o);
					k.show();
					a.brady.validator.setStyle(k, "text");
					a.brady.validator.setBorder(a(f), "focus")
				});
				a(f).blur(function(h) {
					a.brady.validator.setBorder(a(f), "clear");
					return a.brady.validator.validateItem(f, c)
				})
			})
		},
		validateForm : function(e, d) {
			if (typeof (e) == "string") {
				e = document.getElementById(e)
			}
			var b = true;
			var f = e.nodeName;
			var c = a(f + " input,select,textarea");
			c.each(function(h, g) {
				if (!a.brady.validator.needValidate(g, d)) {
					return
				}
				if (!a.brady.validator.validateItem(g, d)) {
					b = false
				}
			});
			return b
		},
		validateFail : function(d, c, b) {
			d.html(c);
			d.show();
			a.brady.validator.setStyle(d, "fail");
			a.brady.validator.setBorder(a(b), "fail")
		},
		validateSucc : function(b) {
			a.brady.validator.setStyle(b, "succ");
			b.html("  ");
			b.show()
		},
		validateItem : function(p, c) {
			var l = a(p).attr("id");
			var x = a(p).val();
			var m;
			var t = c[l].msg_panel_id;
			if (t) {
				m = a("#" + t)
			} else {
				var k = "fail_span_id_" + l;
				m = a.brady.validator.createSpanAfter(k, p)
			}
			m.hide();
			a.brady.validator.setBorder(a(p), "clear");
			var q = c[l].validators;
			var r = c[l].refer;
			if (r) {
				q = c[r].validators;
				l = r
			}
			for ( var g in q) {
				var j = c[l].validators[g].failmsg;
				var u = c[l].validators[g].ignoreEmpty;
				if (u == undefined) {
					u = true
				}
				if (u && g != "required" && a.trim(x).length == 0) {
					return true
				}
				if (g == "required") {
					if (a.trim(x) == "") {
						a.brady.validator.validateFail(m, j, p);
						return false
					}
				} else {
					if (g == "digit") {
						if (!/^\d+$/.test(x)) {
							a.brady.validator.validateFail(m, j, p);
							return false
						}
					} else {
						if (g == "letter") {
							if (!/^[A-Za-z]+$/.test(x)) {
								a.brady.validator.validateFail(m, j, p);
								return false
							}
						} else {
							if (g == "digitOrLetter") {
								if (!/^[A-Za-z0-9]+$/.test(x)) {
									a.brady.validator.validateFail(m, j, p);
									return false
								}
							} else {
								if (g == "number") {
									if (!/^\d+(\.\d+)?$/.test(x)) {
										a.brady.validator.validateFail(m, j, p);
										return false
									}
								} else {
									if (g == "cellphone") {
										if (!/^(\+86)?1\d{10}$/.test(x)) {
											a.brady.validator.validateFail(m,
													j, p);
											return false
										}
									} else {
										if (g == "telphone") {
											if (!/^(\+86-)?(\d{3,4}-+)?\d{7,8}(-\d+)?$/
													.test(x)) {
												a.brady.validator.validateFail(
														m, j, p);
												return false
											}
										} else {
											if (g == "phone") {
												if (!/^(\+86)?1\d{10}$|^(\+86-)?(\d{3,4}-+)?\d{7,8}(-\d+)?$/
														.test(x)) {
													a.brady.validator
															.validateFail(m, j,
																	p);
													return false
												}
											} else {
												if (g == "url") {
													if (!/^[a-zA-z]+:\/\/[^\s]*$/
															.test(x)) {
														a.brady.validator
																.validateFail(
																		m, j, p);
														return false
													}
												} else {
													if (g == "email") {
														if (!/^\w+([-+.]\w+)*@\w+([-.]\w+)*.\w+([-.]\w+)*$/
																.test(x)) {
															a.brady.validator
																	.validateFail(
																			m,
																			j,
																			p);
															return false
														}
													} else {
														if (g == "ip") {
															if (!/^((2[0-4]\d|25[0-5]|[01]?\d\d?)\.){3}(2[0-4]\d|25[0-5]|[01]?\d\d?)$/
																	.test(x)) {
																a.brady.validator
																		.validateFail(
																				m,
																				j,
																				p);
																return false
															}
														} else {
															if (g == "date") {
																if (!/^((((((0[48])|([13579][26])|([2468][048]))00)|([0-9][0-9]((0[48])|([13579][26])|([2468][048]))))-02-29)|(((000[1-9])|(00[1-9][0-9])|(0[1-9][0-9][0-9])|([1-9][0-9][0-9][0-9]))-((((0[13578])|(1[02]))-31)|(((0[1,3-9])|(1[0-2]))-(29|30))|(((0[1-9])|(1[0-2]))-((0[1-9])|(1[0-9])|(2[0-8]))))))$/
																		.test(x)) {
																	a.brady.validator
																			.validateFail(
																					m,
																					j,
																					p);
																	return false
																}
															} else {
																if (g == "personID") {
																	if (!/^\d{17}[Xx0-9]$|^\d{15}$/
																			.test(x)) {
																		a.brady.validator
																				.validateFail(
																						m,
																						j,
																						p);
																		return false
																	}
																} else {
																	if (g == "minLength") {
																		var n = c[l].validators[g].min;
																		var h = new RegExp(
																				"^\\S{"
																						+ n
																						+ ",}$",
																				"");
																		if (!h
																				.test(x)) {
																			a.brady.validator
																					.validateFail(
																							m,
																							j,
																							p);
																			return false
																		}
																	} else {
																		if (g == "maxLength") {
																			var s = c[l].validators[g].max;
																			var h = new RegExp(
																					"^\\S{0,"
																							+ s
																							+ "}$",
																					"");
																			if (!h
																					.test(x)) {
																				a.brady.validator
																						.validateFail(
																								m,
																								j,
																								p);
																				return false
																			}
																		} else {
																			if (g == "range") {
																				var n = c[l].validators[g].min;
																				var s = c[l].validators[g].max;
																				var h = new RegExp(
																						"^\\S{"
																								+ n
																								+ ","
																								+ s
																								+ "}$",
																						"");
																				if (!h
																						.test(x)) {
																					a.brady.validator
																							.validateFail(
																									m,
																									j,
																									p);
																					return false
																				}
																			} else {
																				if (g == "maxBytes") {
																					var s = c[l].validators[g].max;
																					if (a.brady.util
																							.getByteCount(x) > s) {
																						a.brady.validator
																								.validateFail(
																										m,
																										j,
																										p);
																						return false
																					}
																				} else {
																					if (g == "regex") {
																						var v = c[l].validators.regex.express;
																						var d = new RegExp(
																								v,
																								"");
																						if (!d
																								.test(x)) {
																							a.brady.validator
																									.validateFail(
																											m,
																											j,
																											p);
																							return false
																						}
																					} else {
																						if (g == "ajax") {
																							var f = c[l].validators[g].url;
																							f += "?time="
																									+ new Date()
																											.getTime();
																							var i = c[l].validators[g].param;
																							var e = c[l].validators[g].returnText;
																							if (!e) {
																								e = "ok"
																							}
																							var o = {};
																							o[i] = x;
																							var w = a
																									.ajax({
																										url : f,
																										data : o,
																										type : "POST",
																										cache : false,
																										async : false
																									}).responseText;
																							if (w != e) {
																								a.brady.validator
																										.validateFail(
																												m,
																												j,
																												p);
																								return false
																							}
																						} else {
																							if (g == "selected") {
																								if (x == "") {
																									a.brady.validator
																											.validateFail(
																													m,
																													j,
																													p);
																									return false
																								}
																							} else {
																								if (g == "equalsTo") {
																									var b = a("#"
																											+ c[l].validators[g].to);
																									if (x != b
																											.val()) {
																										a.brady.validator
																												.validateFail(
																														m,
																														j,
																														p);
																										return false
																									}
																								}else {
																									if(g == "passwordID"){
																										if (!(/^.*?[\d]+.*$/.test(x)&&/^.*?[A-Za-z].*$/.test(x)&&/^.{5,19}$/.test(x))) {
																	
																											a.brady.validator
																													 .validateFail(
																														     m,
																														     j,
																														     p);
																											 return false
																									    }
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
				a.brady.validator.validateSucc(m)
			}
			return true
		},
		validate : function(d, b) {
			var c = document.getElementById(d);
			if (!c || !b) {
				return
			}
			a.brady.validator.validateItemOnBlur(c, b);
			a(c).submit(function() {
				return a.brady.validator.validateForm(c, b)
			})
		}
	}
});
